import Dashboard from './Dashboard.vue'
import Customer from './Customer.vue'

export default [
    {
        path: 'customer',
        component: Dashboard,
        children: [
            {path: 'cus', component: Customer}
        ]
    }
]