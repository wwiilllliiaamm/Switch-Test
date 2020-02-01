/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  public RobotContainer m_robotContainer;
  public static DigitalInput switchOne, switchTwo, switchThree, switchFour;
  public int switchValue;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.

    // Create auto switches
    m_robotContainer = new RobotContainer();
  
    switchOne = new DigitalInput(1);
    switchTwo = new DigitalInput(2);
    switchThree = new DigitalInput(3);
    switchFour = new DigitalInput(4);
  }




  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */ 
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    // m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    switchValue = 0;
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    if (switchOne.get()) {
      System.out.println("Switch number 1 is on");
      switchValue++;
    }

    if (switchTwo.get()) {
      System.out.println("Switch number 2 is on");
      switchValue+=2;
    
    }

    if (switchThree.get()) {
      System.out.println("Switch number 3 is on");
      switchValue+=4;
    }

    if (switchFour.get()) {
      System.out.println("Switch number FOUR is on");
      switchValue+=8;
    }

    SmartDashboard.putNumber("switchValue", switchValue);

    switch (switchValue) {
    case 1: System.out.println("chocolate");
      break;
    case 2: System.out.println("message");
      break;
    case 3: System.out.println("secret");
      break;
    case 4: System.out.println("I");
      break;
    case 5: System.out.println("super");
      break;
    case 6: System.out.println("my");
      break;
    case 7: System.out.println("have");
      break;
    case 8: System.out.println("to");
      break;
    case 9: System.out.println("favorite");
      break;
    case 10: System.out.println("you");
      break;
    case 11: System.out.println("tell");
      break;
    case 12: System.out.println("is");
      break;
    case 13: System.out.println("dessert");
      break;
    case 14: System.out.println("a");
      break;
    case 15: System.out.println("cake");
      break;
    default: System.out.println("You are starting or have finished");
      break;
    }
    System.out.println("You are learning a super secret code");
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
