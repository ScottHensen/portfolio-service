import org.springframework.cloud.contract.spec.Contract

Contract.make {
    
    description "Given http request, When GET /portfolios, Then all portfolios are returned"
    request {
        method GET()
        url "/portfolios"
    }
    response {
        headers {
            contentType('application/json')
        }
        status(200)
        body( [ [ id: 1L, symbol: "TSLA", shares: 100 ], [ id: 2L, symbol: "AMZN", shares: 50 ] ] )
    }
}
