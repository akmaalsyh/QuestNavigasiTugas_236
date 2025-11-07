package com.example.questnavigasitugas_236.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_236.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirData(
    OnSubmitBtnClick: () -> Unit
)  {
    // --- 1. LOGIKA STATE (Dari Kode Asli Anda) ---
    // Variabel-variabel untuk mengingat nilai masukan
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val status: List<String> = listOf("Janda", "Lajang", "Duda")

    // --- Definisi Warna (Dari Tema Sebelumnya) ---
    val appBackground = colorResource(id = R.color.app_background)
    val purpleHeader = colorResource(id = R.color.purple_header)
    val purpleButton = colorResource(id = R.color.purple_button)
    val textLabel = colorResource(id = R.color.text_label)
    val textFieldBorder = colorResource(id = R.color.purple_header) // Border field

    // --- 2. LOGIKA LAYOUT (Dari File ListTampilanData) ---
    // Menggunakan Scaffold, TopAppBar, dan Column
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = appBackground,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.form_pendaftaran),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Black, // Sesuai gambar
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = purpleHeader // Warna header
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(isiRuang)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()) // Agar bisa di-scroll jika form panjang
        ) {

            // --- 3. LOGIKA FORM (Dari Kode Asli Anda, Disesuaikan) ---

            // 1. Nama Lengkap
            Text(
                text = stringResource(id = R.string.nama_lengkap),
                color = textLabel,
                fontSize = 13.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            // Menggunakan OutlinedTextField tapi di-style agar terlihat seperti di gambar
            OutlinedTextField(
                value = textNama,
                onValueChange = { textNama = it },
                label = { Text(stringResource(id = R.string.nama_lengkap)) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White, // Latar putih
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = textFieldBorder, // Border ungu muda
                    focusedBorderColor = purpleButton // Border ungu tua saat diklik
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 2. Jenis Kelamin
            Text(
                text = stringResource(id = R.string.jenis_kelamin),
                color = textLabel,
                fontSize = 13.sp
            )
            // Logika RadioButton dari kode asli Anda dipertahankan
            gender.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    )
                    Text(text = item, modifier = Modifier.padding(start = 8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 3. Status Perkawinan
            Text(
                text = stringResource(id = R.string.status),
                color = textLabel,
                fontSize = 13.sp
            )
            // Logika RadioButton dari kode asli Anda dipertahankan
            status.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = textStatus == item,
                            onClick = { textStatus = item }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textStatus == item,
                        onClick = { textStatus = item }
                    )
                    Text(text = item, modifier = Modifier.padding(start = 8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 4. Alamat
            Text(
                text = stringResource(id = R.string.alamat),
                color = textLabel,
                fontSize = 13.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            OutlinedTextField(
                value = textAlamat,
                onValueChange = { textAlamat = it },
                label = { Text(stringResource(id = R.string.alamat)) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = textFieldBorder,
                    focusedBorderColor = purpleButton
                )
            )

            // --- 4. LOGIKA SPACER (Dari File ListTampilanData) ---
            // Mendorong tombol ke bawah
            Spacer(modifier = Modifier.weight(1f))

            Spacer(modifier = Modifier.height(32.dp))

            // 5. Tombol Submit
            Button(
                onClick = OnSubmitBtnClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = purpleButton)
            ) {
                Text(
                    text = stringResource(id = R.string.submit),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}