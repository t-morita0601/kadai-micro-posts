package services

import javax.inject.Singleton

import models.{ PagedItems, User }
import scalikejdbc._
import skinny.Pagination
import scala.util.Try

@Singleton
class UserServiceImpl extends UserService {

  // ユーザーの作成に成功した場合は、Success(AUTO_INCREMENTによるID値を返します)
  def create(user: User)(implicit dbSession: DBSession = AutoSession): Try[Long] = Try {
    User.create(user)
  }

  def findByEmail(email: String)(implicit dbSession: DBSession = AutoSession): Try[Option[User]] =
    Try {
      User.where('email -> email).apply().headOption
    }

  // 変更
  def findAll(pagination: Pagination)(implicit dbSession: DBSession = AutoSession): Try[PagedItems[User]] = Try {
    PagedItems[User](
      pagination,
      User.countAllModels(),
      User.findAllWithPagination(pagination, Seq(User.defaultAlias.id.asc))
    )
  }

  // 追加
  override def findById(id: Long)(implicit dbSession: DBSession): Try[Option[User]] = Try {
    User.findById(id)
  }

}
