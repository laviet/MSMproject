import Dashboard from './Dashboard.vue'
import Employee from './Employee.vue'
import UpdateEmployee from './UpdateEmployee.vue'

export default [
    {
        path: 'employee',
        component: Dashboard,
        children: [
            {path: '', component: Employee},
            {path: 'update', component: UpdateEmployee},
        ]
    }
]