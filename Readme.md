# OMD - TP2 - Conception Orientée Objet - Mini-Editeur

# Auteurs: Aubry TONNERRE et Thibault GUERINEL

# Date: 23/10/2023

---

L'objectif de ce TP est de concevoir un éditeur en Java en utilisant un pattern de conception adapté.

Pour des raisons de simplicité, nous avons décidé de faire un éditeur de texte en utilisant Swing mais en implémentant notre propre presse papier.

Dans une première version, nous avons implémenté une version de l'éditeur qui prend en charge les commandes de base (copier, coller, couper, selectionner) et qui donne à l'utilisateur la possibilité d'écrire son texte dans une zone.

Dans une deuxième version, nous avons implémenté une version de l'éditeur qui prend en charge les mêmes commandes que la première version mais qui permet aussi de faire des undo/redo avec l'implémentation d'un historique de commande.

## Organisation du projet

Le projet est organisé en 2 packages principaux:

- v1 - contient la première version de l'éditeur qui à pour objectif de mettre en place le pattern de conception.
- v2 - contient la seconde version de l'éditeur qui à pour objectif de gerer en plus les commandes de undo/redo.

## Pattern de conception utilisé - Commande

Le pattern que nous allons utiliser pour faire ce projet est le pattern de conception Commande.

### Diagramme de classe

<figure>
<img src="pictures/CommandPattern.png" alt="Trulli" style="width:100%">
<figcaption align = "center"><b>Fig.1 - Pattern Command from Refactoring Guru.</b></figcaption>
</figure>

Ce diagramme possède un Client qui pour nous représentera l'éditeur de texte. Il possède une interface Command qui permet de définir les méthodes execute() qui sera implémentée par les classes concrètes CopyCommand, CutCommand, PasteCommand, SelectLeftCommand et SelectRightCommand. Ces classes concrètes implémentent les méthodes execute() de l'interface Command.
Un Invoker aura pour objectif d'appeler les méthodes execute() des classes concrètes. Dans notre cas, nous utiliserons les boutons de l'interface Swing pour appeler les méthodes execute() des classes concrètes.
Les command intéragiront directement avec l'éditeur de texte pour effectuer les actions demandées par l'utilisateur.
Voici le diagramme de use case de notre éditeur:

```plantuml
@startuml
left to right direction
actor "User" as user
rectangle Editor {
  usecase "Ecrire" as UC1
  usecase "selectionner" as UC2
  usecase "deplacer" as UC3
  usecase "copier" as UC4
  usecase "Coller" as UC5
  usecase "Couper" as UC6
  usecase "Effacer" as UC7


(UC3) .> (UC2) : include


}
user --> UC1
user --> UC2
user --> UC3
user --> UC4
user --> UC5
user --> UC6
user --> UC7

@enduml
```

## Presentation de l'éditeur v1

### Arborecence du projet

```
├── src
│   ├── v1
│   │   ├── Command.java
│   │   │── CopyCommand.java
│   │   │── CutCommand.java
│   │   │── Editor.java
│   │   │── MainEditor.java
│   │   │── PasteCommand.java
│   │   │── SelectLeftCommand.java
│   │   │── SelectRightCommand.java
└── UMLDiag
│   ├── v1
└── .gitignore
```

### Diagramme UML 



```mermaid
classDiagram
direction BT
class Command {
<<Interface>>
  + execute() void
}
class CopyCommand {
  + getInstance(Editor) CopyCommand
  + execute() void
}
class CutCommand {
  + execute() void
  + getInstance(Editor) CutCommand
}
class Editor {
   String selectedTextText
   String copyBuffer
   JTextArea textArea
}
class JButton {
  # paramString() String
  + updateUI() void
  + removeNotify() void
  - writeObject(ObjectOutputStream) void
   String UIClassID
   AccessibleContext accessibleContext
   boolean defaultButton
   boolean defaultCapable
}
class MainEditor {
  + main(String[]) void
}
class PasteCommand {
  + getInstance(Editor) PasteCommand
  + execute() void
}
class SelectLeftCommand {
  + execute() void
  + getInstance(Editor) SelectLeftCommand
}
class SelectRightCommand {
  + execute() void
  + getInstance(Editor) SelectRightCommand
}

CopyCommand  ..>  Command 
CopyCommand "1" *--> "editor 1" Editor 
CutCommand  ..>  Command 
CutCommand "1" *--> "editor 1" Editor 
Editor  ..>  JButton : «create»
MainEditor  ..>  Editor : «create»
PasteCommand  ..>  Command 
PasteCommand "1" *--> "editor 1" Editor 
SelectLeftCommand  ..>  Command 
SelectLeftCommand "1" *--> "editor 1" Editor 
SelectRightCommand  ..>  Command 
SelectRightCommand "1" *--> "editor 1" Editor 
```
Nous avons décidé de créer unn classe Editor avec le framework Swing qui donnera à l'utilisateur un accès à une zone de texte (JTextArea) 
ainsi qu'à un ensemble de bouton executant les actions voulus par l'utilisateur.

Pour rappel, l'objectif est de donnée à un utilisateur une zone de texte et des commandes à éxécuter. Nous avons décidé 
d'éxécuter les commandes en utilisants des boutons (JButton). Chaque commandes hérite d'une interface Command qui possède 
une méthode execute() qui sera implémentée par les classes concrètes CopyCommand, CutCommand, PasteCommand, SelectLeftCommand et SelectRightCommand.


#### Execution CopyCommand
```plantuml
@startuml
'https://plantuml.com/sequence-diagram
user -> système: selectionnerTexte
système -> système: detecterZoneSelect
système -> user: surlignageTexte
user -> système: clickCopyButton
système -> système: editor.setCopyBuffer()
@enduml
```



#### Execution CutCommand
```plantuml
@startuml
'https://plantuml.com/sequence-diagram
user -> système: selectionnerTexte
système -> système: detecterZoneSelect
système -> user: surlignageTexte
user -> système: ClickCutButton
système -> système: editor.setCopyBuffer(temp.getSelectedText());
système -> système: textArea.deleteSelection();
système -> user: supprimerTexte
@enduml
```


#### Execution PasteCommand

```plantuml
@startuml
'https://plantuml.com/sequence-diagram'
user -> système: placementCurseur
système -> user: placement
user -> système: clickCopyButton
système -> système: getCopyBuffer()
système -> user: Ajout dans zone de texte
@enduml
```


#### Execution SelectLeftCommand - SelectRightCommand
```plantuml
@startuml
'https://plantuml.com/sequence-diagram
user -> système: selectionnerTexte
user -> système: clickButton()
système -> système: detecterZoneSelect
système -> système: augmenteSelection
système -> user: surlignageTexte
@enduml
```
Il faut noter que dans le cas de la commande SelectRightCommand, la sélection est bien effectué mais sans le surlignage du texte.



## Presentation de l'éditeur v2

### Arborecence du projet


### Diagramme UML
```mermaid
classDiagram
direction BT
class Command {
<<Interface>>
  + execute() void
}
class CopyCommand {
  + execute() void
  + getInstance(Editor) CopyCommand
}
class CutCommand {
  + getInstance(Editor) CutCommand
  + execute() void
}
class Editor {
  + getTextArea() JTextArea
  + getCopyBuffer() String
  + getSelectedTextText() String
  + setTextArea(JTextArea) void
  + setCopyBuffer(String) void
}
class JButton {
  + setDefaultCapable(boolean) void
  + updateUI() void
  + isDefaultButton() boolean
  # paramString() String
  + isDefaultCapable() boolean
  + getAccessibleContext() AccessibleContext
  + getUIClassID() String
  + removeNotify() void
  - writeObject(ObjectOutputStream) void
}
class MainEditor {
  + main(String[]) void
}
class PasteCommand {
  + execute() void
  + getInstance(Editor) PasteCommand
}
class SelectLeftCommand {
  + execute() void
  + getInstance(Editor) SelectLeftCommand
}
class SelectRightCommand {
  + getInstance(Editor) SelectRightCommand
  + execute() void
}

CopyCommand  ..>  Command 
CopyCommand "1" *--> "editor 1" Editor 
CutCommand  ..>  Command 
CutCommand "1" *--> "editor 1" Editor 
Editor  ..>  JButton : «create»
MainEditor  ..>  Editor : «create»
PasteCommand  ..>  Command 
PasteCommand "1" *--> "editor 1" Editor 
SelectLeftCommand  ..>  Command 
SelectLeftCommand "1" *--> "editor 1" Editor 
SelectRightCommand  ..>  Command 
SelectRightCommand "1" *--> "editor 1" Editor 
```

#### Execution Replay
```plantuml

```

#### Execution Redo
```plantuml

```


#### Execution Undo
```plantuml

```


#### Execution historyCommand
```plantuml

```