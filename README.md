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
-
tle: jetpackList
-

classDialogram
 LandmarksList <|-- ListItem
 ListItem <|-- ModelData
 note for ListItem "landmark[0]\landmark[1]\landmark[2]..."

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
