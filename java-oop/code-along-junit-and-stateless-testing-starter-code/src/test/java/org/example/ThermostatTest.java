package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThermostatTest {
    // Set up
    private Thermostat testThermostat;

    @BeforeEach
    void setUp() {
        // Create a new Thermostat
        testThermostat = new Thermostat();
        testThermostat.setTargetTemperature(72);
        testThermostat.setTolerance(2);
    }


    //Assert
    @Test
    public void tempLowHeatShouldBeOn() {
        // Arrange
        int[] temperatures = {72,70,68,69,70};
        // Act
        Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.ON_HEAT;
        Thermostat.ThermostatBehavior actualResult = testThermostat.readSensorData(temperatures);
        // Assert
        assertEquals(expectedResult, actualResult);
    }
        // 1. Head on when Temp is low

    @Test
    public void tempHighACShouldBeOn(){
        // 2. AC ON when Temp is high
        //Arrange
        int[] temperatures = {74,76, 75, 75, 75};
        Thermostat.ThermostatBehavior expected = Thermostat.ThermostatBehavior.ON_AC;
        //Act
        Thermostat.ThermostatBehavior actualResult = testThermostat.readSensorData(temperatures);
        //Assert
        assertEquals(expected, actualResult);
    }

    @Test
    public void tempCorrectSystemOff(){
        // 3. System off when temperature is just right (Within 2 degrees of the target)
        //Arrange
        int[] temperatures = {72, 70, 69, 71,70};
        Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.OFF;
        //Act
        Thermostat.ThermostatBehavior actualResult = testThermostat.readSensorData(temperatures);
        //Assert
        assertEquals(expectedResult, actualResult);

    }
    //Tear Down
}
