# Time Range Calculator

## Overview
This project introduces a utility method designed to manage and calculate the duration, in minutes, between two points in time within a 24-hour period. The core functionality revolves around interpreting a given time range, from a starting hour to an ending hour, and calculating the total minutes encompassed in this interval.

## Challenge Description
The primary challenge lies in accurately calculating the time span in minutes when given a time range as a string. This task involves considering scenarios where the ending time might appear before the starting time when viewed in a sequential 12-hour clock format. This utility method is adept at handling time spans that cross midnight, assuming the end time occurs on the following day.

## Key Considerations:
- __Time Format__: The method accepts time in a 12-hour format, appended with am or pm to denote the time of day.
- __Crossing Midnight__: In cases where the ending time precedes the starting time within the same day, the calculation assumes the ending time belongs to the next day. This is essential for contexts where activities or durations extend past midnight.
- __Input/Output Format__: Input is provided as a string in the format HH:MMam/pm-HH:MMam/pm. The output is an integer representing the total minutes between the start and end times.

## Examples
1. __Input__: 8:30am-10:00am
   </br>__Output__: 90 minutes

2. __Input__: 10:00pm-8:30pm
   </br>__Output__: 1350 minutes