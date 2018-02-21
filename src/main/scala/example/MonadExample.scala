package example

import scala.concurrent.Future

object MonadExample {
  type UserId = String
  type User = String
  type Balance = Int
  type TransactionStatus = Boolean


  def getchUser(str: String): Future[User] = Future.successful("Andrei")

  def fetchAccountBalance(user: User): Future[Balance] = Future.successful(Int.MaxValue)

  def canHeBuy(userId: UserId, requiredBalance: Balance): Future[TransactionStatus] =
    getchUser(userId)
      .flatMap { user =>
        fetchAccountBalance(user)
      }.map(actualBalance => actualBalance <= requiredBalance)

  def canHeBuy2(userId: UserId, requiredBalance: Balance): Future[TransactionStatus] =
    for {
      user <- getchUser(userId)
      balanace <- fetchAccountBalance(user)
    } yield balanace <= requiredBalance
}
