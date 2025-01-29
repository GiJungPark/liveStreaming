package io.livestreaming.api.commerce.presentation.web

import com.fasterxml.jackson.databind.ObjectMapper
import io.livestreaming.api.commerce.application.port.`in`.DonationCoinUseCase
import io.livestreaming.api.commerce.application.port.`in`.PurchaseCoinUseCase
import io.livestreaming.api.commerce.presentation.web.request.DonationCoinRequest
import io.livestreaming.api.commerce.presentation.web.request.PurchaseCoinRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@WebMvcTest(CommerceController::class)
class CommerceControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockBean
    private lateinit var purchaseCoinUseCase: PurchaseCoinUseCase

    @MockBean
    private lateinit var donationCoinUseCase: DonationCoinUseCase

    @Test
    fun `코인 구매 API`() {
        val url = "/commerce/coin/purchase"
        val request = PurchaseCoinRequest(memberId = "validMemberId", quantity = 1000.toBigInteger())

        val response = mockMvc.post(url){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(request)
        }

        response.andExpect { status { isOk() } }
    }

    @Test
    fun `도네이션 API`() {
        val url = "/commerce/coin/donation"
        val request = DonationCoinRequest(memberId = "validMemberId", channelId = "validChannelId", quantity = 1000.toBigInteger())

        val response = mockMvc.post(url){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(request)
        }

        response.andExpect { status { isOk() } }
    }

}
