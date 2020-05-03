package com.mikoiot.apps.access.network

import android.annotation.SuppressLint
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class HttpsTrustManager : X509TrustManager {

    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return _AcceptedIssuers
    }

    @SuppressLint("TrustAllX509TrustManager")
    @Throws(java.security.cert.CertificateException::class)
    override fun checkClientTrusted(
        x509Certificates: Array<X509Certificate>, s: String
    ) {

    }

    @SuppressLint("TrustAllX509TrustManager")
    @Throws(java.security.cert.CertificateException::class)
    override fun checkServerTrusted(
        x509Certificates: Array<X509Certificate>, s: String
    ) {

    }

    fun isClientTrusted(chain: Array<X509Certificate>): Boolean {
        return true
    }

    fun isServerTrusted(chain: Array<X509Certificate>): Boolean {
        return true
    }

    companion object {

        private var trustManagers: Array<TrustManager>? = null
        private val _AcceptedIssuers = arrayOf<X509Certificate>()

        fun allowAllSSL() {
            HttpsURLConnection.setDefaultHostnameVerifier { _, _ ->

                return@setDefaultHostnameVerifier true
            }

            var context: SSLContext? = null
            if (trustManagers == null) {
                trustManagers = arrayOf(
                    HttpsTrustManager()
                )
            }

            try {
                context = SSLContext.getInstance("TLS")
                context!!.init(null,
                    trustManagers, SecureRandom()
                )
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            } catch (e: KeyManagementException) {
                e.printStackTrace()
            }

            HttpsURLConnection.setDefaultSSLSocketFactory(
                context!!.socketFactory
            )
        }
    }

}