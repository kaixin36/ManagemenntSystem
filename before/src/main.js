import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import ElementPlus from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import 'element-plus/dist/index.css'
import * as ElIconModules from '@element-plus/icons-vue'


import '@/assets/css/global.css'

// createApp(App).use(store).use(router).use(ElementPlus, { locale: zhCn,size:'small' }).mount('#app')
let app =createApp(App).use(store).use(router).use(ElementPlus);


for(let iconName in ElIconModules)
{
    app.component(iconName,ElIconModules[iconName]);
}
app.mount('#app');
