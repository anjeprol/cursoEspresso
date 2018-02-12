# Espresso curse
The objetive of this project is show how to build functional test by coding and with espresso tool.


## Index

* [`Gradle configurations`](#gradle)
* [`Espresso`](https://developer.android.com/training/testing/espresso/index.html)
  * [`cheat sheet espresso`](https://developer.android.com/training/testing/espresso/cheat-sheet.html)
  * [`download cheat sheet espresso`](/docs/espresso-cheat-sheet-2.1.0.pdf)
* [`Quick example`](#example-functional-test-code)

### Gradle
```gradle
    androidTestImplementation 'com.android.support.test:runner:1.0.1'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
```

### Example functional test code
```java
@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivity =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void verifyTextChangeWork() {
        /**
         * Adding the first input data.
         */
        onView(withId(R.id.text))
                .perform(typeText("TEST"), closeSoftKeyboard());
        /**
         * Then click the button, change text.
         */
        onView(withId(R.id.changeTextView)).perform(click());
        /**
         * Checking the input at textView below change textView.
         */
        onView(withId(R.id.textView)).check(matches(withText("TEST")));

        /**
         * Then click change activity.
         */
        onView(withId(R.id.changeActivity)).perform(click());

        /**
         * Verify the data at activity 2.
         */
        onView(withId(R.id.text2))
                .check(matches(withText("TEST")));

    }
}
```
[`index`](#index)