package julian.scholler.fitnesscoach.view.user.model

data class User(
    val name: String,
    val age: Int,
    val weight: Long,
    val goal: UserGoal
)
