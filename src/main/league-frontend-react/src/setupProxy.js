const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(
        '/api',
        createProxyMiddleware({
            target: 'https://eun1.api.riotgames.com/lol/platform/v3',
            changeOrigin: true,
        })
    );
};
