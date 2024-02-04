package presentation.view

import account.creation.AccountCreationManager
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.local.DataStorageManager
import event.ThreadEvent
import event.ThreadState
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import presentation.color.Colors
import presentation.color.fromEnum
import utils.exception.ExceptionHandler
import utils.exception.TException

class RegisterScreen {


    /**
     * Register screen for creating new users
     *
     * @param state -> StateManager
     * @param onEvent -> EventManager
     * @param onNavigateLogin -> Navigate to Login screen
     * @param onNavigateHome -> Navigate to Home screen
     * @param localDataManager -> LocalDataManager
     */
    @OptIn(DelicateCoroutinesApi::class, ExperimentalComposeUiApi::class)
    @Composable
    fun RegisterScreen(
        state: ThreadState,
        onEvent: (ThreadEvent) -> Unit,
        localDataManager: DataStorageManager
    ) {
        var user by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var birthday by remember { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        val checkedConditionsState = remember {
            mutableStateOf(false)
        }
        val focusManager = LocalFocusManager.current
        val cornerrad = 10.dp
        var corner = RoundedCornerShape(cornerrad)

        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color.fromEnum(Colors.PRIMARY)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo of the APP
            /*var imageBytes by remember { mutableStateOf<ByteArray?>(null) }
            var loading by remember { mutableStateOf(true) }


            if (loading) {
                LaunchedEffect(loading) {
                    imageBytes = imageDataSource.getImage("LogoTransparent.jpg")
                    loading = false
                }
            }

            imageBytes?.let {
                Photo(
                    width = 150.dp,
                    height = 150.dp,
                    photoBytes = imageBytes
                )
            }*/
            // -----------------

            //Space
            Spacer(modifier = Modifier.height(40.dp))

            //Register headline
            Text(
                text = "REGISTER",
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.fromEnum(Colors.SENARY),
                modifier = Modifier.padding(top = 100.dp)
            )

            //Email textfield
            TextField(
                value = email,
                placeholder = {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "E-Mail",
                            modifier = Modifier.offset(y = -(2).dp, x = 3.dp),
                            color = Color.fromEnum(Colors.SENARY)
                        )
                    }
                },
                onValueChange = { text -> email = text },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(66.dp)
                    .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                    .background(
                        color = Color.fromEnum(Colors.TERTIARY),
                        shape = corner
                    )
                    .border(
                        width = 1.dp,
                        color = Color.fromEnum(Colors.SENARY),
                        shape = corner
                    ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Left,
                    color = Color.fromEnum(Colors.SENARY),
                    fontSize = 14.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                )
            )


            // Textfield for the password
            TextField(
                value = password,
                placeholder = {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Password",
                            modifier = Modifier.offset(y = -(3).dp, x = 3.dp),
                            color = Color.fromEnum(Colors.SENARY)
                        )
                    }
                },
                onValueChange = { text -> password = text },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(66.dp)
                    .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                    .background(
                        color = Color.fromEnum(Colors.TERTIARY),
                        shape = corner
                    )
                    .border(
                        width = 1.dp,
                        color = Color.fromEnum(Colors.SENARY),
                        shape = corner
                    ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Left,
                    color = Color.fromEnum(Colors.SENARY),
                    fontSize = 14.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                )
            )


            //Username Textfield
            TextField(
                value = user,
                placeholder = {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Username",
                            modifier = Modifier.offset(y = -(2).dp, x = 3.dp),
                            color = Color.fromEnum(Colors.SENARY)
                        )
                    }
                },
                onValueChange = { text -> user = text },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(66.dp)
                    .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                    .background(
                        color = Color.fromEnum(Colors.TERTIARY),
                        shape = corner
                    )
                    .border(
                        width = 1.dp,
                        color = Color.fromEnum(Colors.SENARY),
                        shape = corner
                    ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Left,
                    color = Color.fromEnum(Colors.SENARY),
                    fontSize = 14.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                )
            )

            //Birthday Textfield
            TextField(
                value = birthday,
                placeholder = {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Birthday dd.mm.yyyy",
                            modifier = Modifier.offset(y = -(2).dp, x = 3.dp),
                            color = Color.fromEnum(Colors.SENARY)
                        )
                    }
                },
                onValueChange = { text -> birthday = text },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(66.dp)
                    .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                    .background(
                        color = Color.fromEnum(Colors.TERTIARY),
                        shape = corner
                    )
                    .border(
                        width = 1.dp,
                        color = Color.fromEnum(Colors.SENARY),
                        shape = corner
                    ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Left,
                    color = Color.fromEnum(Colors.SENARY),
                    fontSize = 14.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                )
            )

            //Error Messages
            Text(
                text = state.RegisterErrorMessage ?: "",
                color = Color.Red
            )

            //login button
            TextButton(onClick = {
                //TODO
            }) {
                Text(
                    text = "Already have an account? Login",
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    fontSize = 14.sp,
                    color = Color.fromEnum(Colors.SENARY)
                )
            }


            Button(
                onClick = {
                    focusManager.clearFocus()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(66.dp)
                    .padding(start = 65.dp, end = 64.dp, top = 8.dp, bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.fromEnum(Colors.QUATERNARY)),
                shape = corner
            ) {
                Text(
                    text = "Create Account",
                    color = Color.fromEnum(Colors.SENARY),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            //Spacer
            Spacer(Modifier.height(100.dp))

        }


        //Terms of service row
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 650.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = androidx.compose.ui.Modifier.border(
                    2.dp,
                    Color.fromEnum(Colors.SENARY),
                    corner
                ).size(25.dp)
            ) {
                Checkbox(
                    checked = checkedConditionsState.value,
                    onCheckedChange = { checkedConditionsState.value = it },
                    colors = CheckboxDefaults.colors(Color.Transparent),
                )
            }

            Text(
                text = "I accept the terms of use",
                fontSize = 14.sp,
                color = Color.fromEnum(Colors.SENARY),
                modifier = Modifier.padding(start = 10.dp)
            )
        }


    }

    @OptIn(ExperimentalComposeUiApi::class)
    fun submit(email: String, password: String , name: String, birthday: String, companycode: String, onEvent: (ThreadEvent) -> Unit) {
        GlobalScope.launch {
            val acc = AccountCreationManager()
            val response = acc.createAccount(
                email = email,
                birthday = birthday,
                name = name,
                companycode = companycode,
                password = password,
                )
            if(response != TException.SUCCESS001){
                onEvent(ThreadEvent.RegisterErrorMessageUpdate(ExceptionHandler().fetchErrorMessage(response)))
            }
        }
    }
}
