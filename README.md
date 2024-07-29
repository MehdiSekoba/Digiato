# Advanced Android Development Techniques

This is a news application project developed using the MVVM (Model-View-ViewModel) architecture. The app fetches news data from the Digiato website, with a custom backend developed by me. The backend is hosted on my server, and the news updates in real-time whenever there is an update on the Digiato site.


## ScreenShots

splash Screen  light           |  home Screen  light      | 
:-------------------------:|   :-------------------------:|
<img src="https://github.com/MehdiSekoba/Digiato/blob/main/art/Screenshot_2024-07-29-11-40-21-505_com.mehdisekoba.digiato.jpg"/>|<img src="https://github.com/MehdiSekoba/Digiato/blob/main/art/photo_3_2024-07-28_21-16-49.jpg"/> | 

category Screen light         | video Screen light
:-------------------------:|:-------------------------:|
<img src="https://github.com/MehdiSekoba/Digiato/blob/main/art/photo_5_2024-07-28_21-16-49.jpg"/>|<img src="https://github.com/MehdiSekoba/Digiato/blob/main/art/photo_2_2024-07-28_21-16-49.jpg"/> | 

 Profile Screen  light                  
:-------------------------:|
<img src="https://github.com/MehdiSekoba/Digiato/blob/main/art/photo_4_2024-07-28_21-16-49.jpg"/> | 


splash Screen  dark           |  home Screen  dark   | 
:-------------------------:|:-------------------------:|
<img src="https://github.com/MehdiSekoba/Digiato/blob/main/art/Screenshot_2024-07-29-11-41-41-469_com.mehdisekoba.digiato.jpg"/>|<img src="https://github.com/MehdiSekoba/Digiato/blob/main/art/photo_2024-07-28_21-16-22.jpg"/> | 

category Screen dark         | video Screen dark
:-------------------------:|:-------------------------:|
<img src="https://github.com/MehdiSekoba/Digiato/blob/main/art/photo_6_2024-07-28_21-16-49.jpg"/>|<img src="https://github.com/MehdiSekoba/Digiato/blob/main/art/photo_10_2024-07-28_21-16-49.jpg"/> | 

 Profile Screen  dark                  
:-------------------------:|
<img src="https://github.com/MehdiSekoba/Digiato/blob/main/art/photo_1_2024-07-28_21-16-49.jpg"/> | 


## The rest of the features are at the bottom of the video viewing page
## Features

**Splash Screen**  Implemented using 'MotionLayout' with custom loading animations.


   **Shimmer Effect**
   Shimmer Effect: Used for loading indicators to enhance user experience.
 
**Dependency  Injection**
   Dependency Injection: Implemented using Hilt for efficient dependency management.

**Caching By Room**
  Caching: News data is cached to ensure availability when the user is offline.

**Custom Divider**
     Custom Divider: Implemented for RecyclerView items to enhance UI.

**Navigation**
   Navigation: Managed using the Navigation Component.

**DataStore Save Theme**
   Data Storage: Implemented using DataStore for persistent storage.

**Theme Support**
   Theme Support: Includes both dark and light modes, ensuring icons and text adapt to the selected theme.

**Database**
     Database: Implemented using Room with TypeConverter and Database for data management.

**Coroutines**
    Coroutines: Used for asynchronous operations to ensure smooth performance.

**LiveData**
   LiveData and Flow: Used for observing data changes and managing data streams.

**Entity and DAO**
    Entity and DAO: Implemented in Room for efficient data caching.

**Custom Fonts**
     Custom Fonts: Added throughout the project using the Calligraphy library.

**Network Dependency**
      Network Dependency Injection: Custom implementation for managing network dependencies.

**Material Design 3**
     Material Design 3: The project adheres to Material Design 3 guidelines.

**Persian Calendar**
    Persian Calendar: Implemented for users needing a localized calendar.

**Custom Views**
    Custom Views: Developed specific custom views to enhance the UI/UX.

   **Purpose:**
    The primary goal of this project is to demonstrate the implementation of data caching and other modern Android development practices.


## Architecture

- **MVVM Architecture**
  - This project follows the MVVM (Model-View-ViewModel) architecture pattern for a clear separation of concerns and better testability.
 
    Video
    
[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/EgRy7tHZTKs/0.jpg)](https://www.youtube.com/embed/EgRy7tHZTKs?si=2iIJEz82Z9eK9pAj)


## Support

This project includes many more capabilities. Please support the project by giving it a star and forking it.

