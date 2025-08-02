package frc.robot.kotlin.subsystems

import com.ctre.phoenix6.configs.TalonFXConfiguration
import com.ctre.phoenix6.hardware.TalonFX
import com.ctre.phoenix6.signals.InvertedValue
import com.ctre.phoenix6.signals.NeutralModeValue
import edu.wpi.first.util.sendable.SendableBuilder
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.robot.kotlin.Constants
import kotlin.math.abs

object ExampleSubsystem : SubsystemBase() {
    private val CANID = 11;

    private var desiredVoltage = 0.0;

    private val motor = TalonFX(CANID).apply {
        configurator.apply(TalonFXConfiguration().apply {
            MotorOutput.Inverted = InvertedValue.Clockwise_Positive
        })
    }

    override fun initSendable(builder: SendableBuilder) {
        builder.addDoubleProperty("Voltage", { desiredVoltage }, {})
        builder.addIntegerProperty("Can ID", { CANID.toLong() }, {})
    }

    override fun periodic() {

        SmartDashboard.putData(this)

        val convertedPosition = if (abs(Constants.controller.rightY) > 0.08) Constants.controller.rightY else 0.0

        desiredVoltage = convertedPosition * 12
        motor.setVoltage(desiredVoltage)
    }


    //region old
    /*
    /**
     * Example command factory method
     */
    fun exampleMethodCommand() = runOnce {
        // One-time action goes here
    }

    /**
     * Example variable querying a boolean state of the subsystem (for example, a digital sensor).
     */
    val exampleCondition: Boolean get() {
        // Query some boolean state, such as a digital sensor.
        return false;
    }

    /**
     * This method will be called once per scheduler run
     */
    override fun periodic() { }

    /**
     * This method will be called once per scheduler run during simulation
     */
    override fun simulationPeriodic() { }
    */
    //endregion
}