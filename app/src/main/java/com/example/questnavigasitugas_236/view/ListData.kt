package com.example.questnavigasitugas_236.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_236.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListTampilanData(
    OnBerandaBtnClick: () -> Unit,
    OnFormulirBtnClick: () -> Unit // Parameter baru untuk tombol kedua
) {
    // Definisi warna dari gambar
    val appBackground = colorResource(id = R.color.app_background)
    val purpleHeader = colorResource(id = R.color.purple_header)
    val purpleFieldBg = colorResource(id = R.color.purple_field_bg)
    val purpleButton = colorResource(id = R.color.purple_button)
    val textLabel = colorResource(id = R.color.text_label)

    // --- LOGIKA INTI ANDA (List of data) ---
    // Datanya disesuaikan dengan 4 item di gambar
    // Ini mengasumsikan Anda memiliki string ini di strings.xml
    val items = listOf(
        Pair(stringResource(id = R.string.nama_lengkap), stringResource(id = R.string.data_nama)),
        Pair(stringResource(id = R.string.jenis_kelamin), stringResource(id = R.string.data_jenis_kelamin)),
        Pair(stringResource(id = R.string.status), stringResource(id = R.string.data_status)),
        Pair(stringResource(id = R.string.alamat), stringResource(id = R.string.data_alamat))
    )

    Scaffold(
        modifier = Modifier,
        containerColor = appBackground, // Warna background utama
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.list_daftar_peserta),
                        color = Color.Blue, // Warna teks di TopBar
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                },
                // Warna TopBar disesuaikan dengan gambar
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = purpleHeader)
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .fillMaxSize() // Mengisi layar
                .padding(isiRuang) // Padding dari TopBar
                .padding(all = dimensionResource(id = R.dimen.padding_medium)) // Padding 16.dp
        ) {
            // --- LOGIKA INTI ANDA (Iterasi/Loop) ---
            // Kita hanya mengubah *isi* dari loop, bukan loop-nya
            items.forEach { item ->
                // Mengganti Column + Divider dengan Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = purpleFieldBg)
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                    ) {
                        // Teks Label (mis: "NAMA LENGKAP")
                        Text(
                            text = item.first, // Menggunakan .first dari Pair
                            fontSize = 13.sp,
                            color = textLabel // Warna abu-abu
                        )
                        // Teks Value (mis: "Aurelia Kurnianti")
                        Text(
                            text = item.second, // Menggunakan .second dari Pair
                            fontWeight = FontWeight.Normal, // Font biasa, bukan Cursive
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    }
                }
                // Spasi antar card
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
            }

            // Spacer untuk mendorong tombol ke bawah
            Spacer(modifier = Modifier.weight(1f))

            // Tombol "Beranda"
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = OnBerandaBtnClick,
                colors = ButtonDefaults.buttonColors(containerColor = purpleButton)
            ) {
                Text(
                    text = stringResource(id = R.string.beranda),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Tombol "Formulir Pendaftaran" (Baru)
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = OnFormulirBtnClick,
                colors = ButtonDefaults.buttonColors(containerColor = purpleButton)
            ) {
                Text(
                    text = stringResource(id = R.string.form_pendaftaran),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}