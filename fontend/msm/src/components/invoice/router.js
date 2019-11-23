import Dashboard from './Dashboard.vue'
import Import from './Import.vue'
import Export from './Export.vue'

export default [
    {
        path: 'invoice',
        component: Dashboard,
        children: [
            {path: 'import', component: Import},
            {path: 'export', component: Export},
        ]
    }
]