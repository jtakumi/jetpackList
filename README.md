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

## Landmark List Sequence Diagram

```mermaid

---
title: show Landmark info list on scroll screen
---

sequenceDiagram
landmark.json->>LandmarkViewModel:Read landmark info
LandmarkViewModel->>LandmarkList: Column Landmark's info list
LandmarkList->>MainActivity: show scrollable landmark list


```

## Landmark List Class Diagram

```mermaid

---
title: jetpackList
---

classDiagram
 MainActivity <|-- LandmarkList :LazyColumn
 LandmarkList <|-- LandmarkViewModel : LandmarkData
 LandmarkViewModel <|-- LandmarkData: List
 note for LandmarkList " LandmarkData "

 note for LandmarkData " Loading landmark.json 
 # json file contents
 Japanese Landmarks' information
 # class structure
 id:silial number,
 name:Landmark name,
description:simply landmark description
 "

class MainActivity {
    LandmarkList()
}

class LandmarkList {
     ListItem(name,description)
}

class LandmarkViewModel {
    String Landmark.name
    String Landmark.description
}

class LandmarkData {
    Int id
    String name
    String description
}



```

## Theme State

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
