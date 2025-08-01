package frc.robot.kotlin

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.Command

class Robot : TimedRobot() {
    private lateinit var autonomousCommand: Command

    private val robotContainer = RobotContainer()

    /**
     * This block is run when the robot is first started up and should be
     * used for any initialization code.
     */
    init {
        
    }

    /**
    * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
    * that you want ran during disabled, autonomous, teleoperated and test.
    *
    * <p>This runs after the mode specific periodic functions, but before LiveWindow and
    * SmartDashboard integrated updating.
    */
    override fun robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        commandScheduler.run()
    }

    /** This function is called once each time the robot enters Disabled mode. */
    override fun disabledInit() { }

    /** This function is called periodically when the robot is in Disabled mode. */
    override fun disabledPeriodic() { }

    /** This autonomous runs the autonomous command selected by your [RobotContainer] class.  */
    override fun autonomousInit() {
        SmartDashboard.putString("Status", "Initialized")
        autonomousCommand = robotContainer.autonomousCommand

        // schedule the autonomous command (example)
        autonomousCommand.schedule()
    }

    /** This function is called periodically during autonomous.  */
    override fun autonomousPeriodic() { }

    /** This function is called once when entering TeleOp mode */
    override fun teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel()
    }

    /** This function is called periodically during operator control.  */
    override fun teleopPeriodic() { }

    /** This function is called once each time the robot enters Test mode. */
    override fun testInit() {
        // Cancels all running commands at the start of test mode.
        commandScheduler.cancelAll()
    }

    /** This function is called periodically during test mode.  */
    override fun testPeriodic() { }

    /** This function is called once when the robot is first started up.  */
    override fun simulationInit() { }

    /** This function is called periodically whilst in simulation.  */
    override fun simulationPeriodic() { }
}