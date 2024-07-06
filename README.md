# jetpackList
lazy list and change theme

## functions
- show landmarks infomation list from json file.
- scroll view made from jetpack compose
- change app theme
    - dark mode 
    - light mode 
    - blue 
    - red
    - yellow

```mermaid

 LandmarksList <|-- ListItem

class LandmarkList {
     ListItem()
}

class ListItem {
    Landmark.name
     boolen isFavorite
}

class ModelData {
    Int id
    String name
    String description
}

```
