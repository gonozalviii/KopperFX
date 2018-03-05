[![Release](https://jitpack.io/v/gonozalviii/KopperFX.svg)](https://jitpack.io/#gonozalviii/KopperFX)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
# KopperFX
Kotlin Wrapper for JavaFX

## About
KopperFX is a Kotlin Wrapper for JavaFX, which is supposed to simplify the use of JavaFX in Kotlin. For this purpose,
extensions have been written especially for JavaFX. The goal is to be able to write JavaFX quickly and easily without
unnecessary intermediate calls and without changing any core JavaFX concepts.

KopperFX was born in production use and extracted into a separate library as the same extension function 
were used over and over in different projects. Since then a lot of additional functions and functionality has been
added. 

## Usage

To use KopperFX, it can be easily integrated as a dependency:

**Gradle**
```
repositories {
    ...
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile 'com.github.gonozalviii:KopperFX:0.3'
}
```

**Gradle (Kotlin)**
```
repositories {
    ...
    maven("https://jitpack.io" )
}

dependencies {
    implementation("com.github.gonozalviii:KopperFX:0.3")
}
```

**Maven**
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.gonozalviii</groupId>
    <artifactId>KopperFX</artifactId>
    <version>0.3</version>
</dependency>
```

## Examples

The following examples show the differences between the current usage of JavaFX in Kotlin and the usage with KopperFX.

### Adding and removing Children

**Kotlin**
```kotlin
pane.children.add(node)
pane.children.addAll(node1, node2)
pane.children.remove(node)
pane.children.removeAll(node1, node2)
```
**KopperFX**
```kotlin
pane += node
pane.addAll(node1, node2)
pane -= node
pane.removeAll(node1, node2)
```

### Adding and removing Items

**Kotlin**
```kotlin
tableview.items.add(item)
tableview.items.addAll(item1, item2)
tableview.items.remove(item)
tableview.items.removeAll(item1, item2)
```
**KopperFX**
```kotlin
tableview += item
tableview.addAll(item1, item2)
tableview -= item
tableview.removeAll(item1, item2)
```

### Misc

**Kotlin**
```kotlin
//Selected Item
val item = tableView.selectionModel.selectedItem
tableView.selectionModel.select(item)

//Selected Index
val index = tableView.selectionModel.selectedIndex
tableView.selectionModel.select(index)

//Filechooser
filechooser.extensionFilters.add(FileChooser.ExtensionFilter("MP3", "*.mp3"))

//FX Thread
Platform.runLater { println("Kotlin") }

//AnimationTimer
object : AnimationTimer() {
        override fun handle(now: Long) {
                println("Kotlin")
        }
}.start()
```
**KopperFX**
```kotlin
//Selected Item
val item = tableView.selectedItem
tableview.selectedItem = item

//Selected Index
val index = tableView.selectedIndex
tableview.selectedIndex = index

//Filechooser
filechooser.addExtensionFilter("MP3", "*.mp3")

//FX Thread
fxThread { println("KopperFX") }

//AnimationTimer
animationTimer { println("KopperFX") }
```

## Own ideas?

Please use the Github issue system :)