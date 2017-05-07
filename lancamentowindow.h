#ifndef LANCAMENTOWINDOW_H
#define LANCAMENTOWINDOW_H

#include <QMainWindow>

namespace Ui {
class LancamentoWindow;
}

class LancamentoWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit LancamentoWindow(QWidget *parent = 0);
    ~LancamentoWindow();

private slots:
    void on_btn_debito_clicked();

    void on_btn_credito_clicked();

    void on_btn_cancelar_clicked();

    void on_btn_salvar_clicked();

private:
    Ui::LancamentoWindow *ui;
};

#endif // LANCAMENTOWINDOW_H
