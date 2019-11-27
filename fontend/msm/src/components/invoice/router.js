import Dashboard from './Dashboard.vue'
import Import from './Import.vue'
import Export from './Export.vue'
import Statistic from './Statistic.vue'

export default [
    {
        path: 'invoice',
        component: Dashboard,
        children: [
            {path: 'import', component: Import},
            {path: 'export', component: Export},
            {path: 'statistic', component: Statistic},
        ]
    }
]