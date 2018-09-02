package services

import models.{MicroPost, PagedItems}
import scalikejdbc.{AutoSession, DBSession}
import skinny.Pagination

import scala.util.Try

trait MicroPostService {

  def create(microPost: MicroPost)(implicit dbSession: DBSession = AutoSession): Try[Long]

  def deleteById(microPostId: Long)(implicit dbSession: DBSession = AutoSession): Try[Int]

  def updateFavoriteFlag(microPostId: Long, favoriteFlag: Boolean, favoritedId: Long)(implicit dbSession: DBSession = AutoSession): Try[Int]

  def findByFavorite(pagination: Pagination)(implicit dbSession: DBSession = AutoSession): Try[PagedItems[MicroPost]]

  def findByUserId(pagination: Pagination, userId: Long)(
    implicit dbSession: DBSession = AutoSession
  ): Try[PagedItems[MicroPost]]

  def countBy(userId: Long)(implicit dbSession: DBSession = AutoSession): Try[Long]

  def findAllByWithLimitOffset(pagination: Pagination, userId: Long)(
    implicit dbSession: DBSession = AutoSession
  ): Try[PagedItems[MicroPost]]

}
