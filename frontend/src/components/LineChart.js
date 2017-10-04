import { Bar } from 'vue-chartjs';

export default Bar.extend({
  mounted() {
    this.renderChart({
      labels: ['Erstellte Boards', 'Users', 'Cards', 'Inactive', 'Used'],
      datasets: [
        {
          label: 'Data one from August',
          backgroundColor: '#f87979',
          data: [20, 23, 90, 25, 40],
        }, {
          label: 'Data two from September',
          backgroundColor: '#41bbf4',
          data: [10, -12, 23, 47, 89],
        },
      ],
    });
  },
});
