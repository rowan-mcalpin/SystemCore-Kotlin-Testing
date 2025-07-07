package frc.robot.kotlin.commands

import edu.wpi.first.wpilibj2.command.Commands
import frc.robot.kotlin.subsystems.ExampleSubsystem

object Autos {
    fun exampleAuto(subsystem: ExampleSubsystem) = Commands.sequence(subsystem.exampleMethodCommand(), ExampleCommand(subsystem))
}