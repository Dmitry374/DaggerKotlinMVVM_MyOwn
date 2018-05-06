package com.example.mvvm_mytestgrechkakotlin_3.model

/**
 * Created by Dima on 19.04.2018.
 */
object Model {

    data class ItemServerData(val splash: String)

//    data class ItemServerData(val splash: String, val butmenu: List<Butmenu>, val butabout: String,
//                              val butmusic: String, val butphoto: String, val butlinks: String, val textabout: String,
//                              val picabout: String, val links: List<Link>, val music: List<Music>, val photo: List<Photo>)
//
//    data class Butmenu(val icon: String, val name: String)
//    data class Link(val linkicon: String, val linkurl: String)
//    data class Music(val singer: String, val name: String, val song: String)
//    data class Photo(val url: String)

    data class ItemServerMsg(val message: String)

}