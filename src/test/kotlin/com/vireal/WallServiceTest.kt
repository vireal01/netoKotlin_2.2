package com.vireal

import org.junit.Assert.*

class WallServiceTest {
  @org.junit.Test
  fun add() {
    val result = WallService.add(Post())
    assertNotEquals(0, result.id)
  }

  @org.junit.Test
  fun updateCreatedUser() {
    val createdUser = WallService.add(Post())
    val result = WallService.update(Post(id = createdUser.id))
    assertTrue(result)
  }

  @org.junit.Test
  fun updateNotCreatedUser() {
    val createdUser = WallService.add(Post())
    val result = WallService.update(Post(id = (createdUser.id?.plus(1))))
    assertFalse(result)
  }
}