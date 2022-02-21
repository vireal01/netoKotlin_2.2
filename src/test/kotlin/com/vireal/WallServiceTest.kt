package com.vireal

import org.junit.Assert.*

class WallServiceTest {
  @org.junit.Test
  fun add() {
    val result = WallService.add(Post(ownerId = 11))
    assertNotEquals(0, result.id)
  }

  @org.junit.Test
  fun updateCreatedUser() {
    val createdUser = WallService.add(Post(ownerId = 11))
    val result = WallService.update(Post(id = createdUser.id))
    assertEquals(true, result)
  }

  @org.junit.Test
  fun updateNotCreatedUser() {
    val createdUser = WallService.add(Post(ownerId = 11))
    val result = WallService.update(Post(id = (createdUser.id + 1)))
    assertEquals(false, result)
  }
}