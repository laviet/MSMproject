import Dashboard from './Dashboard.vue'
import Customer from './Customer.vue'
import CustomerUpdate from './CustomerUpdate.vue'

export default [
    {
        path: 'customer',
        component: Dashboard,
        children: [
            {path: '', component: Customer},
            {path: 'update', component: CustomerUpdate},
        ]
    }
]