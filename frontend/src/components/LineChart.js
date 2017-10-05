import { Line } from 'vue-chartjs';

export default Line.extend({
  mounted() {
    this.gradient = this.$refs.canvas.getContext('2d').createLinearGradient(0, 0, 0, 450);
    this.gradient2 = this.$refs.canvas.getContext('2d').createLinearGradient(0, 0, 0, 450);

    this.gradient.addColorStop(0, 'rgba(255, 0,0, 0.5)');
    this.gradient.addColorStop(0.5, 'rgba(255, 0, 0, 0.25)');
    this.gradient.addColorStop(1, 'rgba(255, 0, 0, 0)');

    this.gradient2.addColorStop(0, 'rgba(0, 231, 255, 0.9)');
    this.gradient2.addColorStop(0.5, 'rgba(0, 231, 255, 0.25)');
    this.gradient2.addColorStop(1, 'rgba(0, 231, 255, 0)');

    this.renderChart({

      labels: ['Erstellte Boards', 'Users', 'Cards', 'Inactive', 'Used'],
      datasets: [
        {
          label: 'Data one from August',
          borderColor: '#FC2525',
          pointBackgroundColor: 'white',
          borderWidth: 1,
          pointBorderColor: 'white',
          backgroundColor: this.gradient,
          data: [20, 23, 90, 25, 40],
        }, {
          label: 'Data two from September',
          borderColor: '#05CBE1',
          pointBackgroundColor: 'white',
          pointBorderColor: 'white',
          borderWidth: 1,
          backgroundColor: this.gradient2,
          data: [10, -12, 23, 47, 89],
        },
      ],
    }, { reponsive: true, maintainAspectRatio: false });
  },
});
