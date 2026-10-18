VangtiChai - Android Application

Language:
Kotlin

Minimum SDK:
API 21 - Android 5.0 (Lollipop)

Description:
VangtiChai is an Android application that allows the user to enter a
money amount using a custom numeric keypad. The application calculates
the required change using the following Taka notes:

500, 100, 50, 20, 10, 5, 2, and 1.

Features:
- Custom numeric keypad created using Android layouts.
- Digits are appended to the entered amount from the right.
- CLEAR button resets the entered amount.
- Automatically calculates the number of each Taka note required.
- Uses ConstraintLayout as the main layout.
- Supports portrait and landscape orientations.
- Preserves the entered amount and calculated change during rotation.
- Supports both phone and tablet screen sizes.
- Uses alternative resource folders for different screen sizes and orientations.
- Layout dimensions are stored in sizes.xml instead of being hardcoded in the layout XML files.

Tested Devices:

1. Pixel XL
   - Portrait mode
   - Landscape mode
   - Numeric keypad tested
   - Change calculation tested
   - State preservation during rotation tested

2. Nexus 10
   - Portrait mode
   - Landscape mode
   - Numeric keypad tested
   - Change calculation tested
   - State preservation during rotation tested

Example Test:
Entered amount: 688

Calculated change:
500: 1
100: 1
50: 1
20: 1
10: 1
5: 1
2: 1
1: 1


3. Pixel 6
   - Portrait mode
   - Landscape mode
   - Numeric keypad tested
   - Change calculation tested
   - State preservation during rotation tested