package frc.robot.kotlin.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase

class ExampleSubsystem : SubsystemBase() {
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
}