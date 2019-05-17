#!/usr/bin/env python
# Adapted from code at https://pimylifeup.com/raspberry-pi-rfid-rc522/
# Author: Michael Rotuno-Johnson
# rotunomp@miamioh.edu

import RPi.GPIO as GPIO
import SimpleMFRC522
import time

MACHINE_NUMBER = 3
WEIGHT = 40
BUTTON_PIN = 10
BUTTON2_PIN = 38
LED_PIN = 13


GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(BUTTON_PIN, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)
GPIO.setup(BUTTON2_PIN, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)

reader = SimpleMFRC522.SimpleMFRC522()

print("Booting up...")

try:
    text = (str(MACHINE_NUMBER))
    print("Tag is ready to write machine number ")
    reader.write(text)
    print("Written")

    # Count the reps and finish when you have a signal from the writer
    repCounter = 0
    print("Start you workout!")
    while (True):
        if GPIO.input(BUTTON_PIN) == GPIO.HIGH:
            repCounter = repCounter + 1
            print("Reps done: " + str(repCounter))
            # Keep it stuck until the button is released
            while GPIO.input(BUTTON_PIN) == GPIO.HIGH :
                time.sleep(.25)
                # Do nothing
        elif GPIO.input(BUTTON2_PIN) == GPIO.HIGH:
            print("Writing weight and reps...")
            reader.write(str(MACHINE_NUMBER) + "-" + str(repCounter) + "-" + str(WEIGHT))
            break
        else:
            continue
finally:
    GPIO.cleanup()
