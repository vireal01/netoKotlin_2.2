package com.vireal

fun main(){
    WallService.add(Post(
        ownerId = 1312133
    ))
    WallService.add(Post(
        ownerId = 1312134
    ))
  println( WallService.update(Post(id = 1)))
  println(WallService.getAllItems())
}