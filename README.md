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

---
title: show Landmark info list on scroll screen
---

sequenceDiagram
Landmark.json->>ModelData:Read
ModelData->>ListItem: Landmark infomation list
ListItem->>LandmarkList: a Landmark's info according with number
LandmarkList->>MainActivity: Landmark Items data


```


```mermaid

---
title: jetpackList
---

classDiagram
 MainActivity <|-- LandmarkList
 LandmarkList <|-- ListItem : List
 ListItem <|-- ModelData: List
 note for ListItem "landmark[0]
 landmark[1]
 landmark[2]..."

 note for ModelData " Loading Landmark.json 
 # json file contents
 Japanese Landmarks' information"

class MainActivity {
    LandmarkList()
}

class LandmarkList {
     ListItem()
     ListItem()
}

class ListItem {
    String Landmark.name
    String Landmark.description
    boolen isFavorite
}

class ModelData {
    Int id
    String name
    String description
}



```

```mermaid
---
title: System Theme State
---

stateDiagram-v2

s2 : States of change system theme and chage color theme user input.

[*] --> LightTheme

LightTheme --> [*]

LightBlueMode -->[*]
LightRedMode -->[*]
LightyellowMode -->[*]

DarkTheme --> [*]

DarkBlueMode --> [*]
DarkRedMode --> [*]
DarkYellowMode --> [*]


LightTheme --> DarkTheme: system dark mode ON

LightTheme --> LightBlueMode: radio button click
LightTheme --> LightRedMode: radio button click
LightTheme --> LightYellowMode: radio button click

DarkTheme --> LightTheme: system dark mode OFF

DarkTheme --> DarkBlueMode: radio button click
DarkTheme --> DarkRedMode: radio button click
DarkTheme --> DarkYellowMode: radio button click

```
