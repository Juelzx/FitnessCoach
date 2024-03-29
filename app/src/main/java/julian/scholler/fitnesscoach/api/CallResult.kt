package julian.scholler.fitnesscoach.api

sealed interface CallResult<T> {
    data class Success<T>(val value: T): CallResult<T>
    data class Failure<T>(val message: String?): CallResult<T>
}
