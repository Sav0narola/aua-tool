import { Line } from 'vue-chartjs';
import { axios } from 'axios';

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

    axios.get('http://jsonplaceholder.typicode.com/posts')
      .then((response) => { this.posts = response.data; })
      .catch((e) => {
        this.errors.push(e);
      });

    const myMonths = ['August', 'September', 'Oktober', 'November', 'Dezember'];
    const values = [20, 23, 90, 25, 40];

    // const myMonth = function() {
    //   for month in myMonth {
    //     let returnMonth;
    //
    //     returnMonth = month.index;
    //
    //     return returnMonth[index];
    //   }
    // }


    this.renderChart({
      labels: myMonths,
      datasets: [
        {
          label: 'Data one from August',
          borderColor: '#FC2525',
          pointBackgroundColor: 'white',
          borderWidth: 1,
          pointBorderColor: 'white',
          backgroundColor: this.gradient,
          data: values,
        }, {
          label: 'Created Boards per Month',
          borderColor: '#05CBE1',
          pointBackgroundColor: 'white',
          pointBorderColor: 'white',
          borderWidth: 1,
          backgroundColor: this.gradient2,
          data: [10, 12, 23, 47, 89],
        },
      ],
    }, { reponsive: true, maintainAspectRatio: false });
  },
});
