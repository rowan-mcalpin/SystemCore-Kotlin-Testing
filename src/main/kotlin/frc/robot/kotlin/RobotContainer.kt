package frc.robot.kotlin

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import edu.wpi.first.wpilibj2.command.button.Trigger
import frc.robot.kotlin.commands.Autos
import frc.robot.kotlin.commands.ExampleCommand
import frc.robot.kotlin.subsystems.ExampleSubsystem

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
class RobotContainer {
    // Declare subsystems
    private val exampleSubsystem = ExampleSubsystem()

    // Replace with CommandPS4Controller or CommandJoystick if needed
    private val driverController = CommandXboxController(Constants.OperatorConstants.kDriverControllerPort)

    /**
     * This variable is used to pass the autonomous command to the main [Robot] class
     */
    val autonomousCommand: Command
        get() { return Autos.exampleAuto(exampleSubsystem) }

    /**
     * Initialization block, can be used to configure things
     */
    init {
        configureBindings()
    }

    /**
     * Use this method to define your trigger->command mappings. Triggers can be created via the
     * [Trigger] constructor with an arbitrary predicate, or via the named factories in
     * [edu.wpi.first.wpilibj2.command.button.CommandGenericHID]'s subclasses for xbox/ps4 controllers or flight joysticks
     */
    private fun configureBindings() {
        // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
        Trigger { exampleSubsystem.exampleCondition }
            .onTrue(ExampleCommand(exampleSubsystem))

        // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
        // cancelling on release.
        driverController.b().whileTrue(exampleSubsystem.exampleMethodCommand())
    }
}