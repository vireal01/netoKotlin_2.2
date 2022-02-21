package com.vireal

class Comment(
  val count: Int = 0,
  val canPost: Boolean = true,
  val groupCanPost: Int = 0,
  val canOpen: Boolean = true
)

class Copyright(
  val id: Int = 0,
  val link: String = "",
  val name: String = "",
  val type: String = ""
)

class Like(
  val count: Int = 0,
  val userLikes: Boolean = false,
  val canLike: Boolean = true,
  val canPublish: Boolean = true
)

class Reposts(
  val counts: Int = 0,
  val userReposted: Int = 0
)

class View(
  val count: Int = 0
)

class Placeholder()

class Donut(
  val isDonut: Boolean = false,
  val paidDuration: Int = 0,
  val placeholder: Placeholder = Placeholder()
)

data class Post(
  var id: Int = 0,
  val ownerId: Int = 8,
  val fromId: Int = 0,
  val created_by: Int = 0,
  val date: Long = System.currentTimeMillis(),
  val text: String = "",
  val replyOwnerId: Int = 0,
  val replyPostId: Int = 0,
  val friendsOnly: Boolean = false,
  val comments: Comment = Comment(),
  val copyright: Copyright = Copyright(),
  val likes: Like = Like(),
  val reposts: Reposts = Reposts(),
  val views: Int = 0,
  val postType: String = "",
  val signerId: Int = 0,
  val canPin: Boolean = false,
  val canDelete: Boolean = true,
  val canEdit: Boolean = true,
  val isPinned: Boolean = false,
  val markedAsAds: Boolean = false,
  val isFavorite: Boolean = false,
  val donut: Donut = Donut(),
  val postponedId : Int = 0
)

object WallService {
  private var posts = emptyArray<Post>()
  private var id: Int = 0
    get() {
      field += 1
      return field
    }
  fun getAllItems(): String {
    return posts.contentToString()
  }

  fun add(post: Post): Post {
    post.id = id
    posts += post
    return posts.last()
  }

  fun update(post: Post): Boolean {
    var requiredPostIndex = -1
    println(post.toString())
    posts.forEach {
      run {
        if (it.id == post.id) {
          requiredPostIndex = posts.indexOf(it)
        }
      }
    }
    return if (requiredPostIndex == -1){
      false
    } else {
      posts[requiredPostIndex] = Post(
        id = post.id,
        date = post.date,
        ownerId = 99
      )
      true
    }
  }
}


