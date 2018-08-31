package services

import models.User
import scalikejdbc.{AutoSession, DBSession}

import scala.util.Try

trait UserService {

  def create(user: User)(implicit dbSession: DBSession = AutoSession): Try[Long]

  def findByEmail(email: String)(implicit dbSession: DBSession = AutoSession): Try[Option[User]]

  // 追加
  def findAll(implicit dbSession: DBSession = AutoSession): Try[List[User]]

  // 追加
  def findById(id: Long)(implicit dbSession: DBSession = AutoSession): Try[Option[User]]

}
