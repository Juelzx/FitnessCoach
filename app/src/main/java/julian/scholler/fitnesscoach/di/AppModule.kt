package julian.scholler.fitnesscoach.di

import android.content.Context
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import julian.scholler.fitnesscoach.googlesignin.presentation.signin.GoogleAuthUiClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSignInClient(@ApplicationContext context: Context): SignInClient {
        return Identity.getSignInClient(context)
    }

    @Singleton
    @Provides
    fun provideGoogleAuthUiClient(@ApplicationContext context: Context, signInClient: SignInClient): GoogleAuthUiClient {
        return GoogleAuthUiClient(context, signInClient)
    }
}