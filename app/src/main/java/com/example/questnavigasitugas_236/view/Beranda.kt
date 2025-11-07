package com.example.questnavigasitugas_236.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_236.R


@Composable
fun Beranda(
    OnSubmitBtnClick: () -> Unit
) {
    // Definisikan warna ungu dari tombol di gambar
    val purpleButtonColor = Color(0xFF8A63D2)

    // Column adalah layout utama, mengisi seluruh layar
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 16.dp), // Beri padding di sisi
        horizontalAlignment = Alignment.CenterHorizontally // Rata tengah semua item
    ) {

        // 1. Teks "Selamat Datang"
        Text(
            text = stringResource(id = R.string.selamat_datang),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 64.dp)
        )

        Spacer(modifier = Modifier.height(64.dp))

        // 2. Logo
        // PASTIKAN Anda menambahkan file gambar logo Anda ke res/drawable
        // Saya beri nama 'card_lst_logo' sebagai contoh
        Image(
            painter = painterResource(id = R.drawable.logo_umy), // GANTI INI
            contentDescription = "Logo CARD-LST",
            modifier = Modifier.size(160.dp) // Sesuaikan ukuran logo
        )

        Spacer(modifier = Modifier.height(64.dp))

        // 3. Teks Nama
        Text(
            text = stringResource(id = R.string.nama_developer),
            fontSize = 18.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 4. Teks NIM
        Text(
            text = stringResource(id = R.string.nim_developer),
            fontSize = 16.sp,
            color = Color.Gray, // Warna lebih pudar seperti di gambar
            textAlign = TextAlign.Center
        )

        // 5. Spacer (Pendorong)
        // Ini adalah "trik" untuk mendorong tombol ke bagian bawah layar.
        // 'weight(1f)' berarti "ambil semua sisa ruang kosong".
        Spacer(modifier = Modifier.weight(1f))

        // 6. Tombol Submit
        Button(
            onClick = OnSubmitBtnClick,
            modifier = Modifier
                .fillMaxWidth() // Lebar penuh
                .padding(bottom = 32.dp), // Jarak dari bawah
            colors = ButtonDefaults.buttonColors(
                containerColor = purpleButtonColor, // Warna background tombol
                contentColor = Color.White // Warna teks "Submit"
            )
        ) {
            Text(
                text = stringResource(id = R.string.submit),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}