// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntermediateWheel;

public class IntakeAutoCommand extends Command {
  private Intake intakeCommand;
  private IntermediateWheel interwheelCommand;
  private Timer timer;
  private double timerValue;
  /** Creates a new IntakeCommand. */
  public IntakeAutoCommand(Intake intake, IntermediateWheel interwheel, double timerValue) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
    addRequirements(interwheel);
    this.timerValue = timerValue;
    this.intakeCommand = intake;
    this.interwheelCommand = interwheel;
    timer = new Timer();

  }

  // Called when the command is initially scheduled. sdsds
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.intakeCommand.intakeOn();
    this.interwheelCommand.wheelOn();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.intakeCommand.intakeOff();
    this.interwheelCommand.wheelOff();
  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() >= this.timerValue) {
      return true;
    } else {
      return false;
    }
    
  }
}
