# Vocabular 2021 - Personal dictionary app that uses a Room database written in Kotlin.
The user types in the language they are learning and thier native language on first launch.

<img src="https://user-images.githubusercontent.com/58415190/116619382-4375fa00-a938-11eb-9525-4abb0f368cc7.png" width="300" height="600">

Some code showing initialisation of languages:
```kotlin
    private fun initialiseLanguages() {
        val learningLanguage = defineLanguagesFragmentBinding.LearningLanguageField.text.toString()
        val nativeLanguage = defineLanguagesFragmentBinding.NativeLanguageField.text.toString()
        if(learningLanguage.isNotBlank() && nativeLanguage.isNotBlank()){
            val dictionary = Dictionary(0,learningLanguage,nativeLanguage)
            defineLangaugesViewModel.insertDictionary(dictionary)
            navigateToHome()

        } else {
        Toast.makeText(
            requireContext(),
            (R.string.toast_fields_must_be_filled),
            Toast.LENGTH_SHORT
        ).show()
    }
```
The user can add words to their dictionary.

<img src="https://user-images.githubusercontent.com/58415190/116619430-57b9f700-a938-11eb-91ac-a21296a309c9.png" width="300" height="600">
The ability to view the dictionary and delete words.

<img src="https://user-images.githubusercontent.com/58415190/116619451-5e486e80-a938-11eb-9380-dab53de5d4dd.png" width="300" height="600">
The home page informs the user of their most recent word and lets the user change the languages.

<img src="https://user-images.githubusercontent.com/58415190/116619473-656f7c80-a938-11eb-9417-2c26c9520a38.png" width="300" height="600">
Testing of knowledge is possible.

<img src="https://user-images.githubusercontent.com/58415190/116619488-6a343080-a938-11eb-8b15-3a1133d06be8.png" width="300" height="600">
