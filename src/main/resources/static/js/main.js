import Vue from 'vue'
import 'api/resource'
import router from 'router/router'
import App from 'pages/App.vue'
import { connect } from './util/ws'
import Vuetify from 'vuetify'
import '@babel/polyfill'
import store from 'store/store'



if (frontendData.profile) {
    connect()
}


Vue.use(Vuetify)

new Vue({
    vuetify: new Vuetify({}),
    el: '#app',
    store,
    router,
    render: a => a(App)
})