package frc.robot.kotlin

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.CommandScheduler
import frc.robot.kotlin.subsystems.ExampleSubsystem

class Robot : TimedRobot() {

    init {
        ExampleSubsystem
    }

    override fun robotPeriodic() {
        CommandScheduler.getInstance().run()
    }
}