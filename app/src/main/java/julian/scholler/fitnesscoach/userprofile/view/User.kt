package julian.scholler.fitnesscoach.userprofile.view

data class User(
    val name: String,
    val age: Int,
    val weight: Long,
    val goal: UserGoal
)
