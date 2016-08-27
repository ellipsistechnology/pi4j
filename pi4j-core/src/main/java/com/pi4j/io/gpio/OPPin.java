package com.pi4j.io.gpio;

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Library (Core)
 * FILENAME      :  OPPin.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  http://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2016 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */


import java.util.EnumSet;

/**
 * Orange Pi pin definitions for (default) WiringPi pin numbering scheme.
 *
 * @author Ben Millar
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 */
public class OPPin extends PinProvider {

                                                                                // Phys | H3   | Pullup/down | Functions
                                                                                // -----+------+-------------+------------------------------------
	public static final Pin GPIO_00 = createDigitalPin(0, "GPIO 0");            // 11   | PA1  |             | UART2_RX
    public static final Pin GPIO_01 = createDigitalPin(1, "GPIO 1");            // 12   | PD14 |             | RGMII_NULL / MII_TXERR/R / MII_NULL
    public static final Pin GPIO_02 = createDigitalPin(2, "GPIO 2");            // 13   | PA0  |             | UART2_TX
    public static final Pin GPIO_03 = createDigitalPin(3, "GPIO 3");            // 15   | PA3  |             | UART2_CTS
    public static final Pin GPIO_04 = createDigitalPinNoPullDown(4, "GPIO 4");  // 16   | PC4  | pullup      | NAND_CE0
    public static final Pin GPIO_05 = createDigitalPinNoPullDown(5, "GPIO 5");  // 18   | PC7  | pullup      | NAND_RB1
    public static final Pin GPIO_06 = createDigitalPin(6, "GPIO 6");            // 22   | PA2  |             | UART2_RTS
    public static final Pin GPIO_07 = createDigitalAndPwmPin(7, "GPIO 7");      //  7   | PA6  |             | SIM_PWMREN / PWM1
    public static final Pin GPIO_08 = createDigitalPin(8, "GPIO 8");            //  3   | PA12 |             | TWI0_DATA / DI_RX
    public static final Pin GPIO_09 = createDigitalPin(9, "GPIO 9");            //  5   | PA11 |             | TWI0_SCK / DI_TX
    public static final Pin GPIO_10 = createDigitalPinNoPullDown(10, "GPIO 10");// 24   | PC3  | pullup      | NAND_CE1 / SPI0_CS
    public static final Pin GPIO_11 = createDigitalPin(11, "GPIO 11");          // 26   | PA21 |             | PCM0_DIN / SIM_VPPP
    public static final Pin GPIO_12 = createDigitalPin(12, "GPIO 12");          // 19   | PC0  |             | NAND_WE / SPI0_MOSI
    public static final Pin GPIO_13 = createDigitalPin(13, "GPIO 13");          // 21   | PC1  |             | NAND_ALE / SPI0_MISO
    public static final Pin GPIO_14 = createDigitalPin(14, "GPIO 14");          // 23   | PC2  |             | NAND_CLE / SPI0_CLK
    public static final Pin GPIO_15 = createDigitalPin(15, "GPIO 15");          //  8   | PA13 |             | SPI1_CS / UART3_TX
    public static final Pin GPIO_16 = createDigitalPin(16, "GPIO 16");          // 10   | PA14 |             | SPI1_CLK / UART3_RX
    public static final Pin GPIO_21 = createDigitalPin(21, "GPIO 21");          // 29   | PA7  |             | SIM_CLK
    public static final Pin GPIO_22 = createDigitalPin(22, "GPIO 22");          // 31   | PA8  |             | SIM_DATA
    public static final Pin GPIO_23 = createDigitalPin(23, "GPIO 23");          // 33   | PA9  |             | SIM_RST
    public static final Pin GPIO_24 = createDigitalPin(24, "GPIO 24");          // 35   | PA10 |             | SIM_DET
    public static final Pin GPIO_25 = createDigitalPin(25, "GPIO 25");          // 37   | PA20 |             | PCM0_DOUT / SIM_VPPEN
    public static final Pin GPIO_26 = createDigitalPin(26, "GPIO 26");          // 32   | PG8  |             | UART1_RTS
    public static final Pin GPIO_27 = createDigitalPin(27, "GPIO 27");          // 36   | PG9  |             | UART1_CTS
    public static final Pin GPIO_28 = createDigitalPin(28, "GPIO 28");          // 38   | PG6  |             | UART1_TX
    public static final Pin GPIO_29 = createDigitalPin(29, "GPIO 29");          // 40   | PG7  |             | UART1_RX
    public static final Pin GPIO_30 = createDigitalPin(30, "GPIO 30");          // 27   | PA19 |             | PCM0_CLK / TWI1_SDA
    public static final Pin GPIO_31 = createDigitalPin(31, "GPIO 31");          // 28   | PA18 |             | PCM0_SYNC / TWI1_SCK

    protected static Pin createDigitalPinNoPullDown(int address, String name) {
        return createDigitalPin(OPGpioProvider.NAME, address, name,
                EnumSet.of(PinPullResistance.OFF, PinPullResistance.PULL_UP),
                PinEdge.all());
    }

    protected static Pin createDigitalPin(int address, String name) {
        return createDigitalPin(OPGpioProvider.NAME, address, name);
    }

    protected static Pin createDigitalAndPwmPin(int address, String name) {
        return createDigitalAndPwmPin(OPGpioProvider.NAME, address, name);
    }

    // *override* static method from subclass
    // (overriding a static method is not supported in Java
    //  so this method definition will hide the subclass static method)
    public static Pin getPinByName(String name) {
        return PinProvider.getPinByName(name);
    }

    // *override* static method from subclass
    // (overriding a static method is not supported in Java
    //  so this method definition will hide the subclass static method)
    public static Pin getPinByAddress(int address) {
        return PinProvider.getPinByAddress(address);
    }

    // *override* static method from subclass
    // (overriding a static method is not supported in Java
    //  so this method definition will hide the subclass static method)
    public static Pin[] allPins() { return PinProvider.allPins(); }

    // *override* static method from subclass
    // (overriding a static method is not supported in Java
    //  so this method definition will hide the subclass static method)
    public static Pin[] allPins(PinMode ... mode) { return PinProvider.allPins(mode); }
}
