import Dashboard from './Dashboard.vue'
import User from './User.vue'

export default [
    {
        path: 'user',
        component: Dashboard,
        children: [
            {path: 'up', component: User}
        ]
    }
]